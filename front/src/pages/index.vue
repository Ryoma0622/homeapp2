<template>
  <div class="h-full flex justify-center items-center">
    <form method="post" @submit.prevent="submit()">
      <div class="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
        <div class="mb-4">
          <label for="userId">
            ユーザID
          </label>
          <input v-model="userId" type="text" />
        </div>
        <div class="mb-6">
          <label for="password">
            パスワード
          </label>
          <input v-model="password" type="password" />
        </div>
        <div class="flex justify-center">
          <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
            ログイン
          </button>
        </div>
        <div v-if="error" class="flex justify-center">
          {{ error }}
        </div>
      </div>
    </form>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'
import { mapState, mapActions, mapMutations } from 'vuex'
import LocalStorageUtil from '~/utils/LocalStorageUtil'
import { LoginRequestParam } from '~/@types'

export type DataType = {
  userId: string
  password: string
  error: string | null
}

export default Vue.extend({
  layout: 'simple',
  data(): DataType {
    return {
      userId: '',
      password: '',
      error: null
    }
  },
  computed: {
    ...mapState('auth', ['user'])
  },
  created() {
    if (LocalStorageUtil.getUser()) {
      this.$router.push('/input')
    }
  },
  methods: {
    ...mapActions('auth', ['login']),
    ...mapMutations(['setError']),
    submit() {
      const req: LoginRequestParam = {
        userId: this.userId,
        password: this.password
      }
      this.login(req)
        .then(() => {
          this.$router.push('/input')
        })
        .catch((e) => {
          this.setError(e)
        })
    }
  }
})
</script>

<style lang="sass" scoped>
label
  @apply block text-sm font-bold mb-2
input
  @apply shadow appearance-none border rounded w-full py-2 px-3
</style>

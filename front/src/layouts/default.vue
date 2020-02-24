<template>
  <div>
    <header>
      <div class="users">
        <font-awesome-icon icon="users" style="font-size: 30px" />
        <b class="ml-2">{{ user }} Family</b>
      </div>
      <button class="bg-transparent font-semibold hover:text-white px-4 border-solid border-2 rounded">
        <font-awesome-icon icon="sign-out-alt" />
        Logout
      </button>
    </header>
    <div class="m-10">
      <ul class="flex">
        <li class="mr-3">
          <nuxt-link :class="{ active: isInput, nonactive: !isInput }" to="/input">支出入力</nuxt-link>
        </li>
        <li class="mr-3">
          <nuxt-link :class="{ active: isList, nonactive: !isList }" to="/list">一覧</nuxt-link>
        </li>
      </ul>
      <div class="mt-4">
        <nuxt />
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'

export type DataType = {
  user: String
}

export default Vue.extend({
  data(): DataType {
    return {
      user: '上土井'
    }
  },
  computed: {
    isInput() {
      return this.$route.path.includes('input')
    },
    isList() {
      return this.$route.path.includes('list')
    }
  }
})
</script>

<style lang="sass" scoped>
li
  .active
    @apply inline-block border border-blue-500 rounded py-1 px-3 bg-blue-500 text-white
  .nonactive
    @apply inline-block border border-white rounded text-blue-500 py-1 px-3
    &:hover
      @apply border-gray-200 bg-gray-200
</style>

<style>
html {
  font-family: 'Source Sans Pro', -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif;
  font-size: 16px;
  word-spacing: 1px;
  -ms-text-size-adjust: 100%;
  -webkit-text-size-adjust: 100%;
  -moz-osx-font-smoothing: grayscale;
  -webkit-font-smoothing: antialiased;
  box-sizing: border-box;
  background-color: #f6fff7;
}

*,
*:before,
*:after {
  box-sizing: border-box;
  margin: 0;
}

button:focus,
input:focus {
  outline: 0;
}

input[type='number']::-webkit-outer-spin-button,
input[type='number']::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
</style>

<style lang="sass" scoped>
header
  @apply flex justify-between text-gray-100 bg-green-400 py-1 px-2
.users
  @apply w-56 flex items-center
  svg
    @apply text-green-800
</style>

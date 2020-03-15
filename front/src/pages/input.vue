<template>
  <div class="flex justify-center">
    <calculator></calculator>
    <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" @click="test">
      Login
    </button>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'
import UserAPI from '~/api/UserAPI'
import Calculator from '~/components/calculator/Calculator.vue'

export default Vue.extend({
  components: {
    Calculator
  },
  methods: {
    test() {
      console.log(UserAPI.getAdminBoard())
    }
  }
})
</script>

<template>
  <div class="flex justify-center">
    <calculator></calculator>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'
import Calculator from '@/components/calculator/Calculator.vue'

export default Vue.extend({
  components: {
    Calculator
  }
})
</script>

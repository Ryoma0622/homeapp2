<template>
  <section>
    <div class="flex justify-center">
      <calculator></calculator>
    </div>
  </section>
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

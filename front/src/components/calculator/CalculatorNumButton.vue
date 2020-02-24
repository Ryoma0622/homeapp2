<template>
  <div>
    <button @click="$emit('addNum', num)">{{ num }}</button>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'
export default Vue.extend({
  props: {
    num: {
      type: String,
      required: true
    }
  }
})
</script>

<style lang="sass" scoped>
button
  @apply text-gray-700 text-center bg-gray-500 w-12 h-12 border font-black text-white
</style>

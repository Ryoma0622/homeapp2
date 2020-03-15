<template>
  <div>
    <alert />
    <div class="h-screen flex justify-center items-center">
      <nuxt />
    </div>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'
import Alert from '~/components/common/Alert.vue'

export default Vue.extend({
  components: {
    Alert
  }
})
</script>

<template>
  <div>Name: {{ fullName }} Message: {{ message }}</div>
</template>

<script lang="ts">
import Vue, { PropOptions } from 'vue'
import Types from '../@types/index'

type DataType = {
  message: string
}

export default Vue.extend({
  name: 'YourComponent',

  props: {
    user: {
      type: Object,
      required: true
    } as PropOptions<Types.User>
  },

  data(): DataType {
    return {
      message: 'This is a message'
    }
  },

  computed: {
    fullName(): string {
      return `${this.user.firstName} ${this.user.lastName}`
    }
  }
})
</script>

<template>
  <div>リスト</div>
</template>

<script lang="ts">
import Vue from 'vue'
import Types from '~/@types/index'

export type DataType = {
  user: Types.User
}

export default Vue.extend({
  data(): DataType {
    return {
      user: {
        firstName: '上土井',
        lastName: '涼馬'
      }
    }
  }
})
</script>

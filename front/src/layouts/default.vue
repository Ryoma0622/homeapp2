<template>
  <div>
    <header>
      <div class="users">
        <font-awesome-icon icon="users" style="font-size: 30px" />
        <b class="ml-2">{{ user }} Family</b>
      </div>
      <button
        class="bg-transparent font-semibold hover:text-white px-4 border-solid border-2 rounded"
      >
        <font-awesome-icon icon="sign-out-alt" />
        Logout
      </button>
    </header>
    <nuxt />
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
  }
})
</script>

<style>
html {
  font-family: 'Source Sans Pro', -apple-system, BlinkMacSystemFont, 'Segoe UI',
    Roboto, 'Helvetica Neue', Arial, sans-serif;
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

.button--green {
  display: inline-block;
  border-radius: 4px;
  border: 1px solid #3b8070;
  color: #3b8070;
  text-decoration: none;
  padding: 10px 30px;
}

.button--green:hover {
  color: #fff;
  background-color: #3b8070;
}

.button--grey {
  display: inline-block;
  border-radius: 4px;
  border: 1px solid #35495e;
  color: #35495e;
  text-decoration: none;
  padding: 10px 30px;
  margin-left: 15px;
}

.button--grey:hover {
  color: #fff;
  background-color: #35495e;
}
</style>

<style lang="scss" scoped>
header {
  @apply flex justify-between py-1;
  color: #f2f2f2;
  background-color: #42d392;
}
.users {
  @apply w-56 flex items-center;
  svg {
    color: #216144;
  }
}
</style>

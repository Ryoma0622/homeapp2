<template>
  <div class="h-full flex justify-center items-center">
    <form method="post" @submit.prevent="Signin()">
      <div class="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
        <div class="mb-4">
          <label class="block text-grey-darker text-sm font-bold mb-2" for="userId">
            Username
          </label>
          <input id="userId" class="shadow appearance-none border rounded w-full py-2 px-3 text-grey-darker" type="text" placeholder="UserID" name="userId" />
        </div>
        <div class="mb-6">
          <label class="block text-grey-darker text-sm font-bold mb-2" for="password">
            Password
          </label>
          <input id="password" class="shadow appearance-none border border-red rounded w-full py-2 px-3 text-grey-darker mb-3" type="password" name="password" placeholder="******************" />
        </div>
        <div class="flex justify-center">
          <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
            Sign In
          </button>
        </div>
      </div>
    </form>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'

export default Vue.extend({})
</script>

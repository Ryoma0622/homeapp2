<template>
  <div class="max-w-sm rounded overflow-hidden shadow-lg">
    <img
      class="w-full"
      src="https://tailwindcss.com/img/card-top.jpg"
      alt="Sunset in the mountains"
    />
    <div class="px-6 py-4">
      <div class="font-bold text-xl mb-2">
        The Coldest Sunset
      </div>
      <p class="text-gray-700 text-base">
        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatibus
        quia, nulla! Maiores et perferendis eaque, exercitationem praesentium
        nihil.
      </p>
    </div>
    <test :user="user" />

    <button class="btn btn-blue">
      aaaa
    </button>
    <div class="test">
      aaaaaaaaaaa
      <p>aaa</p>
    </div>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'
import Types from '~/@types/index'
import Test from '~/components/Test.vue'

export type DataType = {
  user: Types.User
}

export default Vue.extend({
  components: {
    Test
  },
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

<style lang="scss" scoped>
.test {
  @apply text-blue-300 bg-gray-500 text-center rounded;
  font-size: 100px;

  p {
    @apply text-blue-300 bg-gray-500 text-center rounded;
    font-weight: bold;
  }

  &.p {
    font-style: italic;
  }
}

.btn {
  @apply font-bold py-2 px-4 rounded;
}

.btn-blue {
  @apply bg-blue-500 text-white;
}

.btn-blue:hover {
  @apply bg-blue-600;
}
</style>

<template>
  <div class="w-56">
    <input v-model="price" class="w-full" maxlength="11" />
    <div class="flex">
      <div>
        <div class="row">
          <CalculatorNumButton v-for="n in 3" :key="n" :num="String(n)" @addNum="addNum" />
        </div>
        <div class="row">
          <CalculatorNumButton v-for="n in 3" :key="n" :num="String(n + 3)" @addNum="addNum" />
        </div>
        <div class="row">
          <CalculatorNumButton v-for="n in 3" :key="n" :num="String(n + 6)" @addNum="addNum" />
        </div>
        <div class="row">
          <CalculatorNumButton :num="'0'" @addNum="addNum" />
          <CalculatorNumButton :num="'00'" @addNum="addNum" />
          <button class="clear" @click="price = ''">C</button>
        </div>
      </div>
      <div class="w-full">
        <div class="operation">
          <button class="camera">
            <font-awesome-icon icon="camera" />
          </button>
          <button class="submit">入力</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'
import CalculatorNumButton from '@/components/calculator/CalculatorNumButton.vue'

export type DataType = {
  price: String
}

export default Vue.extend({
  components: {
    CalculatorNumButton
  },
  data(): DataType {
    return {
      price: ''
    }
  },
  watch: {
    price(newValue) {
      const result = newValue.replace(/\D/g, '').replace(/\B(?=(\d{3})+(?!\d))/g, ',')
      Vue.nextTick(() => (this.price = result))
    }
  },
  methods: {
    addNum(num: String) {
      if (this.price.length === 11) {
        return
      }
      if (!this.price && num.includes('0')) {
        return
      }
      this.price = this.price.concat(num as string)
    }
  }
})
</script>

<style lang="sass" scoped>
input
  @apply text-3xl text-right font-bold text-white bg-gray-700 px-2 border
.row
  @apply flex w-auto
.clear
  @apply text-gray-700 text-center bg-orange-500 w-12 h-12 border font-black text-white
.operation
  button
    @apply text-gray-700 text-center bg-green-400 w-full h-24 border font-black text-white text-2xl
</style>

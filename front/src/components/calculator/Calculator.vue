<template>
  <div class="w-56">
    <input v-model="price" class="w-full" maxlength="11" />
    <div class="flex">
      <div>
        <div v-for="keyRow in keyRows" :key="keyRow[0]" class="row">
          <CalculatorNumButton v-for="key in keyRow" :key="key" :num="key" @addNum="addNum" />
          <button v-if="keyRow[0] === '0'" class="clear" @click="price = ''">C</button>
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

const keyRows = [
  ['1', '2', '3'],
  ['4', '5', '6'],
  ['7', '8', '9'],
  ['0', '00']
]

export type DataType = {
  price: String
  keyRows: String[][]
}

export default Vue.extend({
  components: {
    CalculatorNumButton
  },
  data(): DataType {
    return {
      price: '',
      keyRows
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
.button-base
  @apply text-gray-700 text-center border font-black text-white
.clear
  @apply button-base bg-orange-500 w-12 h-12
.operation
  button
    @apply button-base bg-green-400 w-full h-24 border font-black text-white text-2xl
</style>

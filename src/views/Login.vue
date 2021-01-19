<template>
<div id="app">
  <button @click="test">按钮</button>
</div>
</template>

<script>
export default {
  name: "Login",
  data(){
    return {

    }
  },
  methods:{
    async test(){
      const { data } = this.$http.get('/hello')
      alert(data)
    }
  }
}
</script>

<style scoped lang="scss">

</style>

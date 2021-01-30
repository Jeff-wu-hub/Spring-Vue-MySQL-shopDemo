<template>
  <div class="dashboard-container">
  </div>
</template>

<script>
import { login } from '@/api/user'
export default {
  name: 'Dashboard',
mounted() {
  login({user:'admin',password:'123456'})
}

}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>

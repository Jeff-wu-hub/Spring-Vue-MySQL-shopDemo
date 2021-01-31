import { login } from '@/api/user'
const state = {
    name:'',
    photo:'',
    online:true
}
const mutations={
    LOG_IN:async (state,data) =>{
        const res =  await login(data)
            if(res.code === 200){
                state.name = res.data.name
                state.photo = res.data.photo
                state.online = true
            }
    },
    LOG_OUT:(state,data)=>{
        logOut(data)
    }
}
const actions = {
    logIn({commit},{data}){
        commit('LOG_IN',data)
    },
    logOut({commit},{data}){
        commit('LOG_OUT',data)
    }
}
export default {
    namespaced: true,
    state,
    mutations,
    actions
}

import { login } from '@/api/user'
const state = {
    name:'',
    online:0,
    photo:''
}
const mutations={
    LOG_IN: (state,data) =>{
        const res = login(data)
        // state.name = res.data.name
        // state.photo = res.data.photo
        // state.online = res.data.online
        console.log(data)
    },
    LOG_OUT:(state,data)=>{
        const res = logOut(data)
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

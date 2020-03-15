import { Commit } from 'vuex/types'
import AuthorizationAPI from '~/api/AuthorizationAPI'
import LocalStorageUtil from '~/utils/LocalStorageUtil'
import { User, LoginRequestParam } from '~/@types'

const user: User = LocalStorageUtil.getUser()
const initialState: State = user ? { user } : { user: null }

interface State {
  user: User | null
}

interface ActionsParam {
  commit: Commit
}

export const state = (): State => initialState

export const mutations = {
  setUser(state: State, user: User) {
    state.user = user
  }
}

export const actions = {
  login({ commit }: ActionsParam, param: LoginRequestParam) {
    return AuthorizationAPI.login(param).then(
      (user) => {
        commit('setUser', user)
        return Promise.resolve(user)
      },
      (error) => {
        commit('setUser', null)
        return Promise.reject(error)
      }
    )
  },
  logout({ commit }: ActionsParam) {
    AuthorizationAPI.logout()
    commit('setUser', null)
  }
}

import axios from 'axios'
import { LoginRequestParam, User } from '~/@types'

const API_URL = '/api/auth/'

class AuthorizationAPI {
  login(param: LoginRequestParam): Promise<User> {
    return axios
      .post<User>(API_URL + 'login', param)
      .then((response) => {
        if (response.data.jwt) {
          localStorage.setItem('user', JSON.stringify(response.data))
        }
        return Promise.resolve(response.data)
      })
      .catch((e) => {
        return Promise.reject(e)
      })
  }

  logout() {
    localStorage.removeItem('user')
  }
}

export default new AuthorizationAPI()

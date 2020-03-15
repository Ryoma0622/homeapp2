import { User } from '~/@types'

export default class LocalStorageUtil {
  static getUser(): User {
    return localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')!) : null
  }
}

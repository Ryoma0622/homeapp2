import { User } from '~/@types'
import LocalStorageUtil from '~/utils/LocalStorageUtil'

export default class CreateHeader {
  static withAuth() {
    const user: User = LocalStorageUtil.getUser()

    if (user && user.jwt) {
      return { Authorization: 'Bearer ' + user.jwt }
    } else {
      return {}
    }
  }
}

export interface LoginRequestParam {
  userId: string
  password: string
}

export interface User {
  jwt: string
  username: string
  password: string
  roles: string[]
}

import axios, { AxiosResponse } from 'axios'
import CreateHeader from './common/CreateHeader'

const API_URL = '/api/test/'

class UserAPI {
  async getPublicContent(): Promise<string> {
    const res = await axios.get<string>(API_URL + 'all')
    return res.data
  }

  async getUserBoard(): Promise<string> {
    const res: AxiosResponse<string> = await axios.get<string>(API_URL + 'user', { headers: CreateHeader.withAuth() })
    return res.data
  }

  async getModeratorBoard() {
    const res: AxiosResponse<string> = await axios.get<string>(API_URL + 'mod', { headers: CreateHeader.withAuth() })
    return res.data
  }

  async getAdminBoard() {
    const res: AxiosResponse<string> = await axios.get<string>(API_URL + 'admin', { headers: CreateHeader.withAuth() })
    return res.data
  }
}

export default new UserAPI()

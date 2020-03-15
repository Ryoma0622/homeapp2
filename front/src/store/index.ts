interface State {
  error: string | null
}

export const state = (): State => {
  return {
    error: null
  }
}

export const mutations = {
  setError(state: State, error: string) {
    state.error = error
  }
}

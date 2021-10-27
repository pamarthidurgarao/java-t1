import { call, put, takeLatest } from "redux-saga/effects";
import { getMovies } from "./api";
import { movieAPIRequest, movieFetchSucceeded } from "./movieSlice";

function* getMoviesSaga(action) {
  try {
    const data = yield call(getMovies, action.payload);
    yield put({ type: movieFetchSucceeded.type, payload: data });
  } catch (e) {
    yield put({ type: "USER_FETCH_FAILED", message: e.message });
  }
}

function* movieSaga() {
  yield takeLatest(movieAPIRequest, getMoviesSaga);
}

export default movieSaga;

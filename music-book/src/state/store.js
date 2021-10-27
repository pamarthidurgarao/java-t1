import { configureStore } from "@reduxjs/toolkit";
import createSagaMiddleware from "redux-saga";
import { spawn } from "redux-saga/effects";
import movieReducer from "./movie/movieSlice";
import movieSaga from "./movie/saga";

const sagaMiddleware = createSagaMiddleware();

export function* rootSaga() {
  yield spawn(movieSaga);
}

export default configureStore({
  reducer: {
    movie: movieReducer,
  },
  devTools: true,
  middleware: [sagaMiddleware],
});

sagaMiddleware.run(rootSaga);

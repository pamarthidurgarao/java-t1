import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  isLoading: false,
  error: null,
  data: [],
  selectedSong: {},
};
const movieSlice = createSlice({
  name: "movie",
  initialState,
  reducers: {
    movieFetchSucceeded(state, action) {
      state.data = Object.values(action.payload);
    },
    addSong(state, action) {
      state.selectedSong = action.payload;
    },
    movieAPIRequest(state, action) {},
  },
});

export default movieSlice.reducer;

export const { movieFetchSucceeded, movieAPIRequest, addSong } =
  movieSlice.actions;

import axios from "axios";

export default async function generate(data) {
  let response = await axios({
    method: "post",
    url: "http://localhost:9090/api/v1/metadata/generate",
    data: data,
  });
  return Promise.resolve({ ...response.data });
}

async function getMovies() {
  let response = await axios({
    method: "get",
    url: "http://localhost:9091/api/v1/movie",
  });
  return Promise.resolve({ ...response.data });
}

export { getMovies };

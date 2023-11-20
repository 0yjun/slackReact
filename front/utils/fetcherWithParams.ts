import axios from 'axios';

const fetcherWithParams = (url: string, params: any) =>
  axios.post(url, params, { withCredentials: true }).then((Response) => Response.data);

export default fetcherWithParams;

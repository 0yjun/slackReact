import axios from 'axios';

const fetcher = (url: string) => axios.post(url).then((Response) => Response.data);

export default fetcher;

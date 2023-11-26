import fetcher from '@utils/fetcher';
import axios from 'axios';
import React, { FC, useCallback } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import useSWR from 'swr';

const WorkSpace: FC<React.PropsWithChildren> = ({ children }) => {
  const { data, error, mutate } = useSWR('/api/user/login', (url) => fetcher(url));
  const navigate = useNavigate();
  const location = useLocation();

  const onLogout = useCallback((e: any) => {
    axios.post('/api/user/logout', null, {
      withCredentials: true,
    });
  }, []);

  if (!data) {
    navigate('/login', {
      state: { from: location },
      replace: true,
    });
  }

  return (
    <div>
      <button onClick={onLogout}>로그아웃</button>;
    </div>
  );
};

export default WorkSpace;

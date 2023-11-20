import axios from 'axios';
import React, { FC, useCallback } from 'react';

const WorkSpace: FC<React.PropsWithChildren> = ({ children }) => {
  const onLogout = useCallback((e: any) => {
    axios.post('api/user/logout', null, {
      withCredentials: true,
    });
  }, []);
  console.log(children);

  return (
    <div>
      <button onClick={onLogout}>로그아웃</button>;
    </div>
  );
};

export default WorkSpace;

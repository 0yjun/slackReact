import React, { useCallback, useState } from 'react';
import { Button, Error, Form, Header, Input, Label, LinkContainer, Success } from './stypes';
import useInput from '@hooks/useInput';
import axios from 'axios';
import { Link, NavLink, useLocation, useNavigate } from 'react-router-dom';
import useSWR from 'swr';
import fetcher from '@utils/fetcher';
import fetcherWithParams from '@utils/fetcherWithParams';

const Login = () => {
  const [email, onChangeEmail, setEmail] = useInput('');
  const [password, onChangePassword, setPassword] = useInput('');
  const { data, error, mutate } = useSWR('/api/user/login', (url) => fetcherWithParams(url, { email, password }));
  const navigate = useNavigate();
  const location = useLocation();

  const onSubmit = useCallback(
    (e: React.FormEvent) => {
      e.preventDefault();
      axios
        .post('/api/user/login', { email, password }, { withCredentials: true })
        .then((response) => {
          mutate();
          console.log(data);
          console.log(error);
          console.log(mutate());
        })
        .catch((error) => {
          console.log(error.response);
          //setSignUpError(error.response.data);
        });
    },
    [email, password],
  );

  if (data) {
    console.log(data);
    console.log(location);
    // navigate('/workspace/channel', {
    //   state: { from: location },
    //   replace: true,
    // });
  }

  return (
    <div id="container">
      <Header>header</Header>
      <Form onSubmit={onSubmit}>
        <Label id="email-label">
          <span>이메일 주소</span>
          <div>
            <Input type="email" id="email" name="email" value={email} onChange={onChangeEmail} />
          </div>
        </Label>
        <Label id="password-label">
          <span>비밀번호</span>
          <div>
            <Input type="password" id="password" name="password" value={password} onChange={onChangePassword} />
          </div>
        </Label>
        <Button type="submit">로그인</Button>
      </Form>
      <LinkContainer>
        아직 회원이 아니신가요? ㄴ<NavLink to="/signup">회원가입 하러가기</NavLink>
      </LinkContainer>
    </div>
  );
};

export default Login;

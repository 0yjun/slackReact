import React, { useCallback, useState } from 'react';
import { Button, Error, Form, Header, Input, Label, LinkContainer, Success } from './stypes';
import useInput from '@hooks/useInput';
import axios from 'axios';
import { Link, NavLink } from 'react-router-dom';

const SignUp = () => {
  const [email, onChangeEmail, setEmail] = useInput('');
  const [nickname, onChangeNickname, setNickname] = useInput('');
  const [password, onChangePassword, setPassword] = useInput('');
  const [passwordCheck, onChangePasswordCheck, setPasswordCheck] = useInput('');
  const [missMatchError, setMissMatchError] = useInput(false);
  const [signUpSuccess, setSignUpSuccess] = useState(false);
  const [signUpError, setSignUpError] = useState(false);

  const onSubmit = useCallback(
    (e: React.FormEvent) => {
      console.log(missMatchError);
      e.preventDefault();
      if (!missMatchError && nickname) {
        setSignUpError(false);
        axios
          .post('/api/user/', { email, nickname, password })
          .then((response) => {
            console.log(response);
          })
          .catch((error) => {
            console.log(error.response);
            //setSignUpError(error.response.data);
          });

        alert('제출');
      }
    },
    [email, nickname, password, passwordCheck],
  );

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
        <Label id="nickname-label">
          <span>닉네임</span>
          <div>
            <Input type="text" id="nickname" name="nickname" value={nickname} onChange={onChangeNickname} />
          </div>
        </Label>
        <Label id="password-label">
          <span>비밀번호</span>
          <div>
            <Input type="password" id="password" name="password" value={password} onChange={onChangePassword} />
          </div>
        </Label>
        <Label id="password-check-label">
          <span>비밀번호 확인</span>
          <div>
            <Input
              type="password"
              id="password-check"
              name="password-check"
              value={passwordCheck}
              onChange={onChangePasswordCheck}
            />
          </div>
          {missMatchError && <Error>비밀번호가 일치하지 않습니다.</Error>}
          {!nickname && <Error>닉네임을 입력해주세요.</Error>}
          {signUpError && <Error>이미 가입된 이메일입니다.</Error>}
          {signUpSuccess && <Success>회원가입되었습니다! 로그인해주세요.</Success>}
        </Label>
        <Button type="submit">회원가입</Button>
      </Form>
      <LinkContainer>
        이미 회원이신가요? $nbps;
        <NavLink to="/login">로그인 하러 가기</NavLink>
      </LinkContainer>
    </div>
  );
};

export default SignUp;

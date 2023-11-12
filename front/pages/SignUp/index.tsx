import React, { useCallback, useState } from 'react';
import { Header } from './stypes';

const SignUp = () => {
  const [email, setEmail] = useState('');
  const [nickname, setNickname] = useState('');
  const [password, setPassword] = useState('');
  const [passwordCheck, setPasswordCheck] = useState('');
  const [missMatchError, setMissMatchError] = useState(false);

  const onChangeEmail = useCallback((e: React.ChangeEvent<HTMLInputElement>) => {
    setEmail(e.target.value);
  }, []);

  const onChangePassword = useCallback(
    (e: React.ChangeEvent<HTMLInputElement>) => {
      setPassword(e.target.value);
      if (e.target.value != password) {
        setMissMatchError(true);
      }
    },
    [password, passwordCheck],
  );

  const onSubmit = useCallback(
    (e: React.ChangeEvent<HTMLInputElement>) => {
      e.preventDefault();
      if (missMatchError) {
        alert('제출');
      }
    },
    [email, nickname, password, passwordCheck],
  );
  return (
    <div id="container">
      <Header>header</Header>
      
    </div>
  );
};

export default SignUp;

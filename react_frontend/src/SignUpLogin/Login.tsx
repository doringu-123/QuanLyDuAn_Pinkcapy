import { Button, PasswordInput, rem, TextInput } from "@mantine/core";
import { IconAt, IconLock } from "@tabler/icons-react";
import { Link } from "react-router-dom";

const Login = () => {
  return (
    <div className="w-1/2 px-20 flex flex-col justify-center gap-3">
      <div className="text-2xl font-semibold text-orange-500">Login</div>
      <TextInput
        withAsterisk
        leftSection={<IconAt style={{ width: rem(16), height: rem(16) }} />}
        label={<span className="text-orange-500">Email</span>}
        placeholder="Your email"
      />
      <PasswordInput
        withAsterisk
        leftSection={<IconLock style={{ width: rem(18), height: rem(18) }} stroke={1.5} />}
        label={<span className="text-orange-500">Password</span>}
        placeholder="Password"
      />
      <Button variant="filled" color="blue">
        Login
      </Button>
      <div className="mx-auto">
        Don't have an account?{" "}
        <Link to="/signup" className="text-blue-500 hover:underline">
          SignUp
        </Link>
      </div>
    </div>
  );
};

export default Login;
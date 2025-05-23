import { Anchor, Button, Checkbox, PasswordInput, rem, TextInput } from "@mantine/core";
import { IconAt, IconLock } from "@tabler/icons-react";
import { Link } from "react-router-dom";

const SignUp = () => {
  return (
    <div className="w-1/2 px-20 flex flex-col justify-center gap-3">
      <div className="text-2xl font-semibold text-orange-500">Create Account</div>
      <TextInput
        withAsterisk
        label={<span className="text-orange-500">Full Name</span>}
        placeholder="Your name"
      />
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
      <PasswordInput
        withAsterisk
        leftSection={<IconLock style={{ width: rem(18), height: rem(18) }} stroke={1.5} />}
        label={<span className="text-orange-500">Confirm Password</span>}
        placeholder="Confirm password"
      />
      <Checkbox
        label={
          <>
            <span className="text-orange-500">I accept </span>
            <Anchor href="#" target="_blank">
              <span className="text-orange-500">terms & conditions</span>
            </Anchor>
          </>
        }
      />
      <Button variant="filled" color="blue">
        Sign up
      </Button>
      <div className="mx-auto">
        Have an account?{" "}
        <Link to="/login" className="text-blue-500 hover:underline">
          Login
        </Link>
      </div>
    </div>
  );
};

export default SignUp;
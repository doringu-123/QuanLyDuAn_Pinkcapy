import { Anchor, Button, Checkbox, Group, PasswordInput, Radio, rem, TextInput } from "@mantine/core";
import { IconAt, IconLock } from "@tabler/icons-react";
import { Link } from "react-router-dom";
import { useState } from "react";
import { registerUser } from "../../src/Services/UserService";

const form = {
  name: "",
  email: "",
  password: "",
  confirmPassword: "",
  accountType: "APPLICANT",
};

const SignUp = (props: any) => {
  const [data, setData] = useState(form);

  const handleChange = (event: any) => {
    if (typeof event === "string") {
      setData({ ...data, accountType: event });
    } else {
      setData({ ...data, [event.target.name]: event.target.value });
    }
  };

  const handleSubmit = async () => {
    if (data.password !== data.confirmPassword) {
      alert("Passwords do not match!");
      return;
    }
    try {
      const response = await registerUser({
        name: data.name,
        email: data.email,
        password: data.password,
        accountType: data.accountType,
      });
      alert("Sign up successful!");
      console.log(response);
    } catch (error) {
      console.error(error);
      alert("Sign up failed!");
    }
  };

  return (
    <div className="w-1/2 px-20 flex flex-col justify-center gap-3">
      <div className="text-2xl font-semibold text-white">Create Account</div>
      <TextInput
        withAsterisk
        label={<span className="text-white">Full Name</span>}
        placeholder="Your name"
        name="name"
        value={data.name}
        onChange={handleChange}
        classNames={{ input: "text-black placeholder-gray-400" }} // Màu chữ đen
      />
      <TextInput
        withAsterisk
        leftSection={<IconAt style={{ width: rem(16), height: rem(16) }} />}
        label={<span className="text-white">Email</span>}
        placeholder="Your email"
        name="email"
        value={data.email}
        onChange={handleChange}
        classNames={{ input: "text-black placeholder-gray-400" }} // Màu chữ đen
      />
      <PasswordInput
        withAsterisk
        leftSection={<IconLock style={{ width: rem(18), height: rem(18) }} stroke={1.5} />}
        label={<span className="text-white">Password</span>}
        placeholder="Password"
        name="password"
        value={data.password}
        onChange={handleChange}
        classNames={{ input: "text-black placeholder-gray-400" }} // Màu chữ đen
      />
      <PasswordInput
        withAsterisk
        leftSection={<IconLock style={{ width: rem(18), height: rem(18) }} stroke={1.5} />}
        label={<span className="text-white">Confirm Password</span>}
        placeholder="Confirm password"
        name="confirmPassword"
        value={data.confirmPassword}
        onChange={handleChange}
        classNames={{ input: "text-black placeholder-gray-400" }} // Màu chữ đen
      />
      <Radio.Group
        value={data.accountType}
        onChange={handleChange}
        label={<span className="text-white">You are?</span>}
        withAsterisk
      >
        <Group mt="xs">
          <Radio
            className="py-4 px-6 border border-mine-shaft-800 rounded-lg text-white data-[state=checked]:bg-bright-sun-400/5 data-[state=checked]:border-bright-sun-400"
            value="APPLICANT"
            label="Applicant"
          />
          <Radio
            className="py-4 px-6 border border-mine-shaft-800 rounded-lg text-white data-[state=checked]:bg-bright-sun-400/5 data-[state=checked]:border-bright-sun-400"
            value="EMPLOYER"
            label="Employer"
          />
        </Group>
      </Radio.Group>
      <Checkbox
        label={
          <>
            <span className="text-white">I accept </span>
            <Anchor href="#" target="_blank">
              <span className="text-white">terms & conditions</span>
            </Anchor>
          </>
        }
      />
      <Button onClick={handleSubmit} variant="filled" color="blue">
        Sign up
      </Button>
      <div className="text-center text-white">
        Have an account?{" "}
        <Link to="/login" className="text-bright-sun-400 hover:underline">
          Login
        </Link>
      </div>
    </div>
  );
};

export default SignUp;
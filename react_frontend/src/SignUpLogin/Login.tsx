import { Button, PasswordInput, rem, TextInput } from "@mantine/core";
import { IconAt, IconLock } from "@tabler/icons-react";
import { Link, useNavigate } from "react-router-dom";
import { useState } from "react";
import { loginUser } from "../../src/Services/UserService";

const form = {
  email: "",
  password: "",
};

const Login = () => {
  const [data, setData] = useState(form);
  const navigate = useNavigate();

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setData({ ...data, [event.target.name]: event.target.value });
  };

  const handleSubmit = async () => {
    try {
      const res = await loginUser(data);
      // Nếu backend trả về token, bạn có thể lưu lại:
      // localStorage.setItem("token", res.token);
      alert("Login successful!");
      navigate("/profile"); // Chuyển hướng sau khi đăng nhập thành công
    } catch (err) {
      console.log(err);
      alert("Login failed!");
    }
  };

  return (
    <div className="w-1/2 px-20 flex flex-col justify-center gap-3">
      <div className="text-2xl font-semibold text-orange-500">Login</div>
      <TextInput
        withAsterisk
        leftSection={<IconAt style={{ width: rem(16), height: rem(16) }} />}
        label={<span className="text-orange-500">Email</span>}
        placeholder="Your email"
        name="email"
        value={data.email}
        onChange={handleChange}
      />
      <PasswordInput
        withAsterisk
        leftSection={<IconLock style={{ width: rem(18), height: rem(18) }} stroke={1.5} />}
        label={<span className="text-orange-500">Password</span>}
        placeholder="Password"
        name="password"
        value={data.password}
        onChange={handleChange}
      />
      <Button variant="filled" color="blue" onClick={handleSubmit}>
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
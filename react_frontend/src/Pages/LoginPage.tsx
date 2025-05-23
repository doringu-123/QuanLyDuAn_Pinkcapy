import { Divider } from "@mantine/core";
import Login from "../SignUpLogin/Login";

const LoginPage = () => {
  return (
    <div className="min-h-[90vh] bg-gray-900 font-['poppins']">
      <Divider size="xs" mx="md" color="blue" />
      <div className="w-[100vw] h-[100vh] flex items-center justify-center bg-gray-800">
        <div className="w-1/2 h-full rounded-r-[200px] bg-white flex flex-col justify-center items-start p-16 shadow-lg">
          <div className="mb-6">
            <div className="text-6xl font-semibold text-blue-700">TalentHub</div>
          </div>
          <div className="text-2xl text-gray-500 font-semibold">
            Chào mừng bạn quay lại!
          </div>
        </div>
        <div className="flex-1 flex items-center justify-center">
          <Login />
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
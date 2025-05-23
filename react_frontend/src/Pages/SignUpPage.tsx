import { Divider } from "@mantine/core";
import SignUp from "../SignUpLogin/SignUp";
import { use } from "react";
import { useLocation } from "react-router-dom";

const SignUpPage = () => {
  const location =useLocation();
  return (
    <div className="min-h-[90vh] bg-gray-900 font-['poppins']">
      <Divider size="xs" mx="md" color="blue" />
      <div className="w-[100vw] h-[100vh] flex items-center justify-center bg-gray-800">
        <div className="w-1/2 h-full rounded-r-[200px] bg-white flex flex-col justify-center items-start p-16 shadow-lg">
          <div className="mb-6">
            <div className="text-6xl font-semibold text-blue-700">TalentHub</div>
          </div>
          <div className="text-2xl text-gray-500 font-semibold">
            Ai cũng phải bắt đầu từ đâu đó
          </div>
        </div>
        <div className="flex-1 flex items-center justify-center">
          <SignUp />
        </div>
      </div>
    </div>
  );
};

export default SignUpPage;
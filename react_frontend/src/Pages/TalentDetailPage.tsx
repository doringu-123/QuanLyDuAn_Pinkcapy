import { Avatar, Button } from "@mantine/core";
import { useParams, useNavigate } from "react-router-dom";

const TalentDetailPage = () => {
  const { id } = useParams();
  const navigate = useNavigate();

  // Dữ liệu mẫu (có thể thay bằng API thực tế)
  const talent = {
    id: 1,
    name: "Nguyễn Văn A",
    title: "Kỹ sư phần mềm",
    location: "Hà Nội",
    skills: ["React", "Node.js", "TypeScript"],
    experience: "3 năm kinh nghiệm tại công ty ABC",
    education: "Cử nhân Công nghệ Thông tin - Đại học Bách Khoa",
    description:
      "Tôi là một kỹ sư phần mềm với hơn 3 năm kinh nghiệm trong việc phát triển các ứng dụng web. Tôi có kỹ năng mạnh về React, Node.js và TypeScript. Tôi luôn tìm kiếm cơ hội để học hỏi và phát triển trong môi trường làm việc chuyên nghiệp.",
  };

  return (
    <div className="min-h-[100vh] bg-blue-50 font-['Poppins'] p-10">
      <div className="bg-white rounded-lg shadow-lg p-8 max-w-4xl mx-auto">
        <div className="flex items-center gap-6 mb-8">
          <Avatar size="xl" src="/avatar.png" alt={talent.name} />
          <div>
            <h1 className="text-2xl font-semibold text-blue-600">{talent.name}</h1>
            <p className="text-gray-500">{talent.title}</p>
          </div>
        </div>
        <div className="mb-6">
          <h2 className="text-lg font-semibold text-blue-600">Thông tin chi tiết</h2>
          <p className="text-gray-500">Địa điểm: {talent.location}</p>
          <p className="text-gray-500">Kinh nghiệm: {talent.experience}</p>
          <p className="text-gray-500">Học vấn: {talent.education}</p>
        </div>
        <div className="mb-6">
          <h2 className="text-lg font-semibold text-blue-600">Giới thiệu</h2>
          <p className="text-gray-500">{talent.description}</p>
        </div>
        <div className="flex flex-wrap gap-2 mb-6">
          {talent.skills.map((skill, idx) => (
            <span
              key={idx}
              className="bg-blue-100 text-blue-600 px-3 py-1 rounded-full text-xs"
            >
              {skill}
            </span>
          ))}
        </div>
        <div className="flex justify-end">
          <Button
            className="bg-blue-500 hover:bg-blue-600 text-white"
            onClick={() => navigate("/talent")}
          >
            Quay lại
          </Button>
        </div>
      </div>
    </div>
  );
};

export default TalentDetailPage;
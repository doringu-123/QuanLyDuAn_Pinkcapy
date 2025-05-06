import { Avatar, Button, Card, Text } from "@mantine/core";
import { useNavigate } from "react-router-dom";

const TalentPage = () => {
  const navigate = useNavigate();

  const talents = [
    {
      id: 1,
      name: "Nguyễn Văn A",
      title: "Kỹ sư phần mềm",
      location: "Hà Nội",
      skills: ["React", "Node.js", "TypeScript"],
    },
    {
      id: 2,
      name: "Trần Thị B",
      title: "Nhà thiết kế đồ họa",
      location: "TP. Hồ Chí Minh",
      skills: ["Photoshop", "Illustrator", "Figma"],
    },
    {
      id: 3,
      name: "Lê Văn C",
      title: "Chuyên viên phân tích dữ liệu",
      location: "Đà Nẵng",
      skills: ["Python", "SQL", "Power BI"],
    },
  ];

  return (
    <div className="min-h-[100vh] bg-blue-50 font-['Poppins'] p-10">
      <div className="text-center mb-10">
        <h1 className="text-3xl font-semibold text-blue-600">Danh sách tài năng</h1>
        <p className="text-gray-500">Khám phá các ứng viên tiềm năng</p>
      </div>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        {talents.map((talent) => (
          <Card
            key={talent.id}
            shadow="sm"
            padding="lg"
            className="bg-white transition-all duration-300 transform hover:scale-95 hover:border-blue-500 hover:border-2 cursor-pointer"
            onClick={() => navigate(`/talent/${talent.id}`)}
          >
            <div className="flex items-center gap-4 mb-4">
              <Avatar size="lg" src="/avatar.png" alt={talent.name} />
              <div>
                <h2 className="text-lg font-semibold text-blue-600">{talent.name}</h2>
                <p className="text-sm text-gray-500">{talent.title}</p>
              </div>
            </div>
            <Text size="sm" color="dimmed" className="mb-4">
              Địa điểm: {talent.location}
            </Text>
            <div className="flex flex-wrap gap-2">
              {talent.skills.map((skill, idx) => (
                <span
                  key={idx}
                  className="bg-blue-100 text-blue-600 px-3 py-1 rounded-full text-xs"
                >
                  {skill}
                </span>
              ))}
            </div>
          </Card>
        ))}
      </div>
    </div>
  );
};

export default TalentPage;
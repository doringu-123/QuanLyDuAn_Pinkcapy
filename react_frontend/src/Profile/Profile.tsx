import { Button, Divider } from "@mantine/core";
import { IconBriefcase, IconMapPin } from "@tabler/icons-react";
import ExpCard from "./ExpCard";
import CertiCard from "./CertiCard";

const profile = {
  experience: [
    {
      company: "Google",
      position: "Kỹ sư phần mềm",
      duration: "01/2020 - Hiện tại",
      description:
        "Phát triển các ứng dụng web có khả năng mở rộng cao sử dụng React và SpringBoot. Dẫn dắt nhóm 5 kỹ sư hoàn thành các dự án có tác động lớn.",
      logo: "/Companies/Google.png",
    },
    {
      company: "Meta",
      position: "Lập trình viên Frontend",
      duration: "06/2017 - 12/2019",
      description:
        "Phát triển giao diện người dùng với React và Redux. Cải thiện hiệu năng và khả năng truy cập cho các tính năng chính.",
      logo: "/Companies/Meta.png",
    },
  ],
  certifications: [
    {
      name: "AWS Certified Solutions Architect",
      issuer: "Amazon Web Services",
      year: 2021,
      company: "Amazon",
    },
    {
      name: "Certified Kubernetes Administrator",
      issuer: "Cloud Native Computing Foundation",
      year: 2020,
      company: "Google",
    },
    {
      name: "Meta Front-End Developer",
      issuer: "Meta",
      year: 2022,
      company: "Meta",
    },
  ],
};

const Profile = () => {
  const skills = [
    "React", "SpringBoot", "MongoDB", "HTML", "CSS", "JavaScript", "Node.js", "Express", "MySQL",
    "Python", "Django", "Figma", "Sketch", "Docker", "AWS"
  ];

  return (
    <div className="w-full flex justify-center items-center min-h-[100vh] bg-gray-100">
      <div className="w-2/3 bg-white rounded-2xl shadow-lg p-8">
        <div className="relative flex flex-col items-center">
          <img className="rounded-t-2xl w-full h-64 object-cover" src="/background.jpg" alt="" />
          <img
            className="w-48 h-48 border-blue-900 border-8 absolute -bottom-24 left-1/2 -translate-x-1/2 rounded-full object-cover bg-gray-100"
            src="/thien.jpg"
            alt="avatar"
          />
        </div>
        <div className="px-3 mt-32">
          <div className="text-3xl font-semibold flex justify-between items-center">
            Nguyễn Hải Thiện
            <Button color="blue" variant="light">
              Nhắn tin
            </Button>
          </div>
          <div className="text-xl flex gap-1 items-center text-gray-700 mt-2">
            <IconBriefcase className="h-5 w-5" stroke={1.5} />
            Kỹ sư phần mềm &bull; Google
          </div>
          <div className="text-lg flex gap-1 items-center text-gray-500 mt-1">
            <IconMapPin className="h-5 w-5" stroke={1.5} />
            New York, Hoa Kỳ
          </div>
          <Divider my="xl" />
          <div>
            <div className="text-2xl font-semibold mb-3 text-blue-900">Giới thiệu</div>
            <div className="text-sm text-gray-600 text-justify">
              Là một Kỹ sư phần mềm tại Google, tôi chuyên xây dựng các ứng dụng có khả năng mở rộng và hiệu năng cao. Tôi có kinh nghiệm tích hợp công nghệ frontend và backend để mang lại trải nghiệm người dùng liền mạch. Với nền tảng vững chắc về React, SpringBoot và tập trung vào MongoDB cho giải pháp cơ sở dữ liệu, tôi đam mê áp dụng công nghệ mới để giải quyết các vấn đề phức tạp và thúc đẩy đổi mới. Mục tiêu của tôi là tạo ra phần mềm có tác động, nâng cao hiệu suất làm việc và đáp ứng tốt nhu cầu người dùng.
            </div>
          </div>
          <Divider my="xl" />
          <div>
            <div className="text-2xl font-semibold mb-3 text-blue-900">Kỹ năng</div>
            <div className="flex flex-wrap gap-2">
              {skills.map((skill, index) => (
                <div
                  key={index}
                  className="bg-blue-100 rounded-3xl px-3 py-1 text-sm font-medium text-blue-700"
                >
                  {skill}
                </div>
              ))}
            </div>
          </div>
          <Divider my="xl" />
          <div>
            <div className="text-2xl font-semibold mb-4 text-blue-900">Kinh nghiệm làm việc</div>
            <div className="flex flex-col gap-8">
              {profile.experience.map((exp: any, index: number) => (
                <ExpCard key={index} {...exp} />
              ))}
            </div>
          </div>
          <Divider my="xl" />
          <div>
            <div className="text-2xl font-semibold mb-4 text-blue-900">Chứng chỉ</div>
            <div className="flex flex-col gap-8">
              {profile.certifications.map((certi: any, index: number) => (
                <div key={index} className="flex items-center gap-4">
                  <img
                    src={`/${certi.company}.png`}
                    alt={certi.company}
                    className="w-16 h-16 object-contain rounded-md border border-gray-200 bg-gray-50"
                  />
                  <CertiCard
                    title={certi.name}
                    organization={certi.issuer}
                    issueDate={certi.year}
                    certificateId={`#${index + 1}`}
                  />
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Profile;
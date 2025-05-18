import { useParams } from "react-router-dom";
import { Card, Text, Badge, Button } from "@mantine/core";
import { jobList } from "../Data/JobsData";

const JobDetailPage = () => {
  const { id } = useParams();
  const job = jobList[parseInt(id || "0")];

  const recommendedJobs = jobList.filter((_, index) => index !== parseInt(id || "0")).slice(0, 3);

  return (
    <div className="min-h-[100vh] bg-blue-50 font-['Poppins'] p-10">
      <div className="bg-white rounded-lg shadow-lg p-8 max-w-4xl mx-auto mb-10">
        {/* Logo và thông tin công ty */}
        <div className="flex items-center gap-6 mb-6">
          <img
            src={`/Companies/${job.company}.png`}
            alt={`${job.company} Logo`}
            className="w-24 h-24 object-contain rounded-md"
          />
          <div>
            <h1 className="text-2xl font-semibold text-blue-600">{job.jobTitle}</h1>
            <p className="text-gray-500">{job.company}</p>
            <Badge color="blue" variant="light" className="mt-2">
              {job.jobType}
            </Badge>
          </div>
        </div>

        {/* Thông tin chi tiết */}
        <div className="mb-6">
          <h2 className="text-lg font-semibold text-blue-600">Thông tin công việc</h2>
          <Text size="sm" color="dimmed" className="mt-2">
            <strong>Địa điểm:</strong> {job.location}
          </Text>
          <Text size="sm" color="dimmed">
            <strong>Mức lương:</strong> {job.package}
          </Text>
          <Text size="sm" color="dimmed">
            <strong>Số lượng ứng viên:</strong> {job.applicants} người
          </Text>
          <Text size="sm" color="dimmed">
            <strong>Đăng cách đây:</strong> {job.postedDaysAgo} ngày
          </Text>
        </div>

        {/* Mô tả công việc */}
        <div className="mb-6">
          <h2 className="text-lg font-semibold text-blue-600">Mô tả công việc</h2>
          <p className="text-gray-500">{job.description}</p>
        </div>

        {/* Nút ứng tuyển */}
        <div className="flex justify-end">
          <Button className="bg-blue-500 hover:bg-blue-600 text-white">
            Ứng tuyển ngay
          </Button>
        </div>
      </div>

      {/* Recommended Jobs */}
      <div className="bg-white rounded-lg shadow-lg p-8 max-w-4xl mx-auto">
        <h2 className="text-lg font-semibold text-blue-600">Recommended Jobs</h2>
        <div className="grid grid-cols-1 gap-4 mt-4">
          {recommendedJobs.map((job, index) => (
            <Card
              key={index}
              shadow="sm"
              padding="lg"
              className="bg-white cursor-pointer hover:shadow-md"
            >
              <h3 className="text-blue-600 font-semibold">{job.jobTitle}</h3>
              <p className="text-gray-500">{job.company}</p>
            </Card>
          ))}
        </div>
      </div>
    </div>
  );
};

export default JobDetailPage;
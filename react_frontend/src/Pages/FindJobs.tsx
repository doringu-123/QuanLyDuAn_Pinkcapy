import Footer from "../Footer/Footer";
import Header from "../Header/Header";
import SearchBar from "../FindJobs/SearchBar"; // Adjust the path as needed
import Jobs from "../FindJobs/Jobs"; // Adjust the path as needed
import { Divider } from "@mantine/core";
import { useNavigate } from "react-router-dom";
import { Card, Text } from "@mantine/core";
import { jobList } from "../Data/JobsData";

const FindJobs = () => {
  const navigate = useNavigate();

  return (
    <div className="min-h-[100vh] bg-blue-50 font-['Poppins'] p-10">
      <h1 className="text-3xl font-semibold text-blue-600 mb-6">Tìm việc</h1>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        {jobList.map((job, index) => (
          <Card
            key={index}
            shadow="sm"
            padding="lg"
            radius="md"
            className="bg-white transition-all duration-300 transform hover:scale-105 hover:shadow-lg cursor-pointer"
            onClick={() => navigate(`/find-jobs/${index}`)}
          >
            <div className="flex items-center gap-4 mb-4">
              <img
                src={`/Companies/${job.company}.png`}
                alt={`${job.company} Logo`}
                className="w-20 h-20 object-contain rounded-md" // Đảm bảo hình ảnh hiển thị đầy đủ
              />
              <div>
                <h2 className="text-lg font-semibold text-blue-600">{job.jobTitle}</h2>
                <p className="text-sm text-gray-500">{job.company}</p>
              </div>
            </div>
            <Text size="sm" color="dimmed" className="mb-2">
              Địa điểm: {job.location}
            </Text>
            <Text size="sm" color="dimmed">
              Mức lương: {job.package}
            </Text>
          </Card>
        ))}
      </div>
    </div>
  );
};

export default FindJobs;
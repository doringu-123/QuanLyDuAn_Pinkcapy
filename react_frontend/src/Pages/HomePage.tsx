import Header from "../Header/Header";
import DreamJob from "../LandingPage/DreamJob";
import Companies from "../LandingPage/Companies";
import JobCategory from "../LandingPage/JobCategory";

const HomePage = () => {
  return (
    <div className="min-h-[100vh] bg-white">
      <Header />
      <DreamJob />
      {/* Thêm thành phần Companies để hiển thị ảnh */}
      <Companies />
      <JobCategory />
    </div>
  );
};

export default HomePage;
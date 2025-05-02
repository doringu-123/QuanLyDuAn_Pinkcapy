import Header from "../Header/Header";
import DreamJob from "../LandingPage/DreamJob";
import Companies from "../LandingPage/Companies";
import JobCategory from "../LandingPage/JobCategory";
import Working from "../LandingPage/Working";
import Testimonials from "../LandingPage/Testimonials";
import Subscribe from "../LandingPage/Subscribe"; // Ensure this path is correct
import Footer from "../Footer/Footer"; // Ensure this path is correct

const HomePage = () => {
  return (
    <div className="min-h-[100vh] bg-white">
      <Header />
      <DreamJob />
      {/* Thêm thành phần Companies để hiển thị ảnh */}
      <Companies />
      <JobCategory />
      <Working />
      <Testimonials/>
      <Subscribe/>
      <Footer />
    </div>
  );
};

export default HomePage;
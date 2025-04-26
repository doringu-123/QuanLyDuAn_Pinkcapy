import Header from "../Header/Header";
import DreamJob from "../LandingPage/DreamJob";

const HomePage = () => {
  return (
    <div className="min-h-[100vh] bg-white">
      <Header />
      <div>
        <DreamJob />
      </div>
    </div>
  );
};

export default HomePage;
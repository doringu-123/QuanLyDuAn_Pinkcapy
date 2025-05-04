import Footer from "../Footer/Footer";
import Header from "../Header/Header";
import SearchBar from "../FindJobs/SearchBar"; // Adjust the path as needed
import Jobs from "../FindJobs/Jobs"; // Adjust the path as needed
import { Divider } from "@mantine/core";

const FindJobs = () => {
  return (
    <div className="min-h-[100vh] bg-mine-shaft-950 font-['poppins']">
        <SearchBar/>
        <Divider size="xs" mx="md" />
      <Jobs />
      
    </div>
  );
};

export default FindJobs;
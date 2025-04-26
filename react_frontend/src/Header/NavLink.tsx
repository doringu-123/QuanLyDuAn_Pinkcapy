import { Link, useLocation } from "react-router-dom";

const NavLinks = () => {
  const links = [
    { name: "Tìm việc", url: "/find-jobs" }, // Thêm dấu "/" trước mỗi URL
    { name: "Tìm ứng viên", url: "/find-talent" },
    { name: "Đăng tin tuyển dụng", url: "/upload-job" },
    { name: "About us", url: "/about" },
  ];

  const location = useLocation();

  return (
    <div className="flex gap-5 text-mine-shaft-300 h-full items-center">
      {links.map((link, index) => (
        <div
          key={index}
          className={`${
            location.pathname === link.url
              ? "border-bright-sun-400"
              : "transparent"
          } border-t-[3px] h-full flex items-center`}
        >
          <Link to={link.url}>{link.name}</Link>
        </div>
      ))}
    </div>
  );
};

export default NavLinks;
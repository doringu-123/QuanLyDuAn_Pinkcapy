import { Link, useLocation } from "react-router-dom";

const NavLinks = () => {
  const links = [
    { name: "Tìm việc", url: "/find-jobs" },
    { name: "Đăng tin tuyển dụng", url: "/post-job" },
    { name: "Tài năng", url: "/talent" },
    { name: "Trang chủ", url: "/" },
    { name: "SignUp", url: "/signup" }
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
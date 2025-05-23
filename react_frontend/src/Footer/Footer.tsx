import { IconAnchor, IconBrandFacebook, IconBrandInstagram, IconBrandX } from "@tabler/icons-react";
import { footerLinks } from "../Data/Data";
import { useLocation } from "react-router-dom";

const Footer = () => {
  const location = useLocation();

  if (location.pathname === "/signup") return null;

  return (
    <div className="mt-20 pb-5 flex gap-5 justify-around">
      <div className="w-1/4 flex flex-col gap-4">
        <div className="flex gap-1 items-center text-bright-sun-400">
          <IconAnchor className="h-7 w-7" stroke={2.5} />
          <div className="text-xl font-semibold">TalentHub</div>
        </div>
        <div className="text-sm text-mine-shaft-300 mt-3">
          Job portal with user profiles, skill updates, notifications, work experience, and admin job postings.
        </div>
        <div className="flex gap-3 text-bright-sun-400 [&>div]:bg-mine-shaft-900 [&>div]:p-2 [&>div]:rounded-full [&>div]:cursor-pointer hover:[&>div]:bg-bright-sun-400 [&>div]:transition-all [&>div]:duration-300">
          <div>
            <IconBrandFacebook className="h-6 w-6 text-bright-sun-400" />
          </div>
          <div>
            <IconBrandInstagram className="h-6 w-6 text-bright-sun-400" />
          </div>
          <div>
            <IconBrandX className="h-6 w-6 text-bright-sun-400" />
          </div>
        </div>
      </div>
      <div className="w-3/4 grid grid-cols-3 gap-5">
        {footerLinks.map((item, index) => (
          <div key={index}>
            <div className="text-lg font-semibold text-mine-shaft-100 mb-3">{item.title}</div>
            {item.link.map((link, idx) => (
              <div
                key={idx}
                className="text-mine-shaft-300 hover:text-bright-sun-400 cursor-pointer mb-1 hover: translate-x-2"
              > 
                {link}
              </div>
            ))}
          </div>
        ))}
      </div>
    </div>
  );
};

export default Footer;
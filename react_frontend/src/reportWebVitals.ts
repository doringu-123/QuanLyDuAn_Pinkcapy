import {
  onCLS,
  onFID,
  onFCP,
  onLCP,
  onTTFB
} from 'web-vitals';

type ReportHandler = (metric: { name: string; value: number }) => void;

const reportWebVitals = (onPerfEntry?: ReportHandler) => {
  if (onPerfEntry && typeof onPerfEntry === 'function') {
    onCLS(onPerfEntry);
    onFID(onPerfEntry);
    onFCP(onPerfEntry);
    onLCP(onPerfEntry);
    onTTFB(onPerfEntry);
  }
};

export default reportWebVitals;
